import { Campus } from './../_model/campus';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CampusService {

  url: string = `${environment.HOST_URL}/campus`;
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Campus[]>(this.url);
  }
}
