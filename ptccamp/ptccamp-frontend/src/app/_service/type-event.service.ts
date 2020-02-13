import { TypeEvent } from './../_model/typeEvent';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TypeEventService {


  url: string = `${environment.HOST_URL}/typeevents`;
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<TypeEvent[]>(this.url);
  }
}
