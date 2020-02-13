import { ServerErrorsInterceptor } from './_shared/server-errors.interceptor';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';



import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EventComponent } from './pages/event/event.component';
import { CampusComponent } from './pages/campus/campus.component';

@NgModule({
  declarations: [
    AppComponent,
    EventComponent,
    CampusComponent
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    FlexLayoutModule,
    BrowserAnimationsModule,
  ],
  providers: [/*{
    provide: HTTP_INTERCEPTORS,
    useClass: ServerErrorsInterceptor,
    multi: true,
  }*/],
  bootstrap: [AppComponent]
})
export class AppModule { }
