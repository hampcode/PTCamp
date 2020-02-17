import { Attention } from './../models/attention';
import { FullTimeTeacher } from './../models/full-time-teacher';
import { Student } from 'src/app/models/student';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AttentionsService {

  private baseEndpoint = "http://localhost:8080";
  private headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  public getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseEndpoint + '/students');
  }

  public getFullTimeTeachers(): Observable<FullTimeTeacher[]> {
    return this.http.get<FullTimeTeacher[]>(this.baseEndpoint + '/fulltimeteachers');
  }

  public register(attention: Attention): Observable<Attention> {
    return this.http.post<Attention>(`${this.baseEndpoint}/attentions`, attention,
      { headers: this.headers });
  }

}
