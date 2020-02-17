import { StudyMode } from './../models/study-mode';
import { Career } from './../models/career';
import { Student } from './../models/student';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  private baseEndpoint = "http://localhost:8080";
  private headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  public getAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.baseEndpoint + '/students');
  }

  public getCareers(): Observable<Career[]> {
    return this.http.get<Career[]>(this.baseEndpoint + '/careers');
  }

  public getStudiesModality(): Observable<StudyMode[]> {
    return this.http.get<StudyMode[]>(this.baseEndpoint + '/studiesmodality');
  }

  public getAllPageable(page: string, size: string): Observable<any> {
    let params = new HttpParams();
    params = params.set('page', page)
    params = params.set('size', size);
    return this.http.get<any>(`${this.baseEndpoint}/students/pageable`, { params: params });
  }

  public getById(id: number): Observable<Student> {
    return this.http.get<Student>(`${this.baseEndpoint}/students/${id}`);
  }

  public register(student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.baseEndpoint}/students`, student,
      { headers: this.headers });
  }

  public update(student: Student): Observable<Student> {
    return this.http.put<Student>(`${this.baseEndpoint}/students/${student.id}`, student,
      { headers: this.headers });
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseEndpoint}/students/${id}`);
  }

}
