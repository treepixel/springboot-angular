import { Component, OnInit } from '@angular/core';
import { faPen, faTimes } from '@fortawesome/free-solid-svg-icons';

import { ApiService } from '../../services/api.service';
import { Product } from 'src/app/model/product';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.less']
})
export class ListComponent implements OnInit {
  public faPen = faPen;
  public faTimes = faTimes;
  public products: Product[];
  
  constructor(
    private apiService: ApiService,
  ) { }
  
  //function to delete product of api
  deleteProduct(id: number, $event): void {
    $event.preventDefault()
    this.apiService.deleteProduct(id)
    .subscribe(product => {
      this.products = this.products.filter(product => product.id !== id);
    });
  }

  ngOnInit() {
    
    //Assing this.products with products from api
    this.apiService.getProducts()
    .subscribe(data => this.products = data)
  }

}
