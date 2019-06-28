import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListComponent } from './components/list/list.component'
import { FormComponent } from './components/form/form.component'

const routes: Routes = [
  { path: '', component: ListComponent },
  { path: 'adicionar-produto', component: FormComponent },
  { path: 'editar-produto/:id', component: FormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
