

import { AttentionsComponent } from './components/attentions/attentions.component';
import { StudentsComponent } from './components/students/students.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentsFormComponent } from './components/students/students-form.component';
import { AttentionsFormComponent } from './components/attentions/attentions-form.component';



const routes: Routes = [
  { path: 'students', component: StudentsComponent },
  { path: 'students/form', component: StudentsFormComponent },
  { path: 'students/form/:id', component: StudentsFormComponent },
  { path: 'attentions', component: AttentionsComponent },
  { path: 'attentions/form', component: AttentionsFormComponent },
  { path: 'attentions/form/:id', component: AttentionsFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
