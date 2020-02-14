import { StudentsService } from './../../services/students.service';
import { Component, OnInit } from '@angular/core';
import { Student } from 'src/app/models/student';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  title: 'Listado de Alumnos';
  students:Student[];
  constructor(private service: StudentsService) { }

  ngOnInit(): void {
  }

}
