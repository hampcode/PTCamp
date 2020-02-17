import { FullTimeTeacher } from './../../models/full-time-teacher';
import { AttentionsService } from './../../services/attentions.service';
import { StudentsService } from './../../services/students.service';
import { Component, OnInit } from '@angular/core';
import { Attention } from 'src/app/models/attention';
import { Router, ActivatedRoute } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-attentions-form',
  templateUrl: './attentions-form.component.html',
  styleUrls: ['./attentions-form.component.css']
})
export class AttentionsFormComponent implements OnInit {

  title: string = 'Nueva Atención de Alumno';
  attention: Attention = new Attention();
  fullTimeTeachers: FullTimeTeacher[];

  error: any;

  constructor(
    private studentService: StudentsService,
    private attentionService: AttentionsService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(params => {
      let studentId = +params.get('id');
      this.studentService.getById(studentId).subscribe(student => this.attention.student = student);
    });

    this.attentionService.getFullTimeTeachers().subscribe(fullTimeTeachers => this.fullTimeTeachers = fullTimeTeachers);

  }


  public newAttention(): void {
    this.attentionService.register(this.attention).subscribe(attention => {
      console.log(attention);
      Swal.fire('Nuevo:', `Atención de Alumno ${attention.student.firstName} , ${attention.student.lastName} creado con éxito`, 'success');
      this.router.navigate(['/attentions']);
    }, err => {
      if (err.status === 400) {
        this.error = err.error;
        console.log(this.error);
      }
    });
  }

  compareFullTimeTeacher(o1: FullTimeTeacher, o2: FullTimeTeacher): boolean {
    if (o1 === undefined && o2 === undefined) {
      return true;
    }

    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id === o2.id;
  }

}
