import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router'
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { switchMap } from 'rxjs/operators';

import { ApiService } from '../../services/api.service';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.less']
})
export class FormComponent implements OnInit {
  
  public form: FormGroup;
  public product: Product;
  public modeEdition: string;
  public productId: number;
  
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder, 
    private apiService: ApiService, 
  ) { }

  ngOnInit() {

    //Build the form and settings validators
    this.form = this.formBuilder.group({
      'nome': [null, [ Validators.required, 
        Validators.minLength(5), 
        Validators.maxLength(200) ]],
      'veiculoAplicacao': [null, [Validators.required,
        Validators.minLength(5), 
        Validators.maxLength(200) ]],
      'pesoLiquido': [null, [ Validators.required]],
      'pesoBruto': [null, [ Validators.required ]],
    });

    //Check if is edition or new Product
    this.route.params.subscribe((params: Params) => {
      if(params.id){
        this.modeEdition = 'edit';
        this.productId = params.id;
        this.apiService.getProduct(params.id)
          .subscribe(product => this.form.patchValue(product));

      }
    });
  }

  //Submit form weather new product or edit product
  submit() {   
    if(this.modeEdition == 'edit'){
      this.apiService.updateProduct(
        this.mapDataToProduct(this.form.value) 
      )
    } else {
      this.apiService.addProduct(
        this.mapDataToProduct(this.form.value)
      )
      .subscribe(hero => {
        console.log(hero)
        this.router.navigate(['']);
      });
    }
    
  } 

  //function to treat data from form.value and creates a new Product object
  mapDataToProduct(data: any): Product {
    return new Product(
      data.nome,
      data.veiculoAplicacao,
      data.pesoLiquido,
      data.pesoBruto,
      null,
      null,
    )
  }
}
