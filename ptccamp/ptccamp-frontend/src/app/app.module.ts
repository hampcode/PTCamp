
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
//import { LayoutModule } from './layout/layout.module';
import { AppComponent } from './app.component';
import { StudentsComponent } from './components/students/students.component';
import { AttentionsComponent } from './components/attentions/attentions.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule } from '@angular/forms';
import { StudentsFormComponent } from './components/students/students-form.component';
import { AttentionsFormComponent } from './components/attentions/attentions-form.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    AttentionsComponent,
    StudentsFormComponent,
    AttentionsFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //LayoutModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatPaginatorModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
