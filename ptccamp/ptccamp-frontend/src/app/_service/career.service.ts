import { Career } from './../_model/career';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CareerService {

  url: string = `${environment.HOST_URL}/campus`;
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Career[]>(this.url);
  }
}
