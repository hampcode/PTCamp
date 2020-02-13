import { FullTimeTeacher } from './../_model/fullTimeTeacher';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FulltimeteacherService {

  url: string = `${environment.HOST_URL}/fulltimeteachers`;
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<FullTimeTeacher[]>(this.url);
  }
}
