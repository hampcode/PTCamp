import { EventAuthorities } from './../models/event-authorities';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  private baseEndpoint = "http://localhost:8080";
  private headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  public register(eventDTO: EventAuthorities): Observable<EventAuthorities> {
    return this.http.post<EventAuthorities>(`${this.baseEndpoint}/events`, eventDTO,
      { headers: this.headers });
  }
}
