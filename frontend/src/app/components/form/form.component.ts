import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router'
import { FormBuilder, FormGroup, FormControl, Validators, AbstractControl } from '@angular/forms';
import { switchMap } from 'rxjs/operators';

import { ApiService } from '../../services/api.service';
import { Product } from 'src/app/model/product';

function checkIfPesoLiquidoIsLessThanPesoBruto (c: AbstractControl) {
  return (c.get('pesoLiquido').value <= c.get('pesoBruto').value) ? null : {invalidPesoLiquido: true} 
}

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
      'id':[null],
      'createdAt':[null],
      'updatedAt':[null],
      'nome': [null, [ Validators.required, 
        Validators.minLength(5), 
        Validators.maxLength(200) ]],
      'veiculoAplicacao': [null, [Validators.required,
        Validators.minLength(5), 
        Validators.maxLength(200) ]],
      'pesoLiquido': [null, [ Validators.required, Validators.min(0.01) ]],
      'pesoBruto': [null, [ Validators.required, Validators.min(0.01) ]],
    }, { validators: checkIfPesoLiquidoIsLessThanPesoBruto });

    //Check if is edition or new Product
    this.route.params.subscribe((params: Params) => {
      if(params.id){
        this.modeEdition = 'edit';
        this.apiService.getProduct(params.id)
          .subscribe(product => this.form.patchValue(product));
      }
    });
  }

  //Submit form weather new product or edit product
  submit() {   
    if(this.modeEdition == 'edit'){
      this.apiService.updateProduct(this.form.value)
        .subscribe(
          () => this.router.navigate(['']),
          errors => console.log(errors)
        );
    } else {
      this.apiService.addProduct(this.form.value)
        .subscribe(
          () => this.router.navigate(['']),
          errors => console.log(errors)
        );
    }
  } 
}
