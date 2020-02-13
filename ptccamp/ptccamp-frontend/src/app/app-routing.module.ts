import { AttentionsComponent } from './components/attentions/attentions.component';
import { StudentsComponent } from './components/students/students.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path:'students',component: StudentsComponent},
  {path:'attentions',component: AttentionsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
