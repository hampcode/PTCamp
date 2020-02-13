
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
//import { LayoutModule } from './layout/layout.module';
import { AppComponent } from './app.component';
import { StudentsComponent } from './components/students/students.component';
import { AttentionsComponent } from './components/attentions/attentions.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    AttentionsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //LayoutModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
