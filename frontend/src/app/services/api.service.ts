import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from '../model/product'
import { HttpHeaders } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  readonly API_URL = 'http://localhost:8080/api';

  addProduct (product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.API_URL}/products`, product, httpOptions)
  }

  getProducts (): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.API_URL}/products?sort=nome,asc`)
      .pipe(
        map((value: any) => value.content)
      )
  }

  updateProduct (product: Product): Observable<Product> {
    return this.http.put<Product>(`${this.API_URL}/products`, product, httpOptions)
  }

  getProduct (id: number): Observable<Product> {
    return this.http.get<Product>(`${this.API_URL}/products/${id}`)
  }

  deleteProduct (id: number): Observable<{}> {
    return this.http.delete(`${this.API_URL}/products/${id}`, httpOptions)
  }
}
