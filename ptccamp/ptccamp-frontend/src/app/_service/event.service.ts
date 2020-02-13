import { Event } from './../_model/event';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { EventDTO } from '../_model/eventDTO';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  url: string = `${environment.HOST_URL}/events`;
  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Event[]>(this.url);
  }

  getById(id: number) {
    return this.http.get<Event>(`${this.url}/${id}`);
  }

  register(event: EventDTO) {
    return this.http.post(this.url, event);
  }

}
