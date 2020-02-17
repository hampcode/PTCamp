import { StudyMode } from './../../models/study-mode';
import { StudentsService } from './../../services/students.service';
import { Student } from 'src/app/models/student';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Career } from 'src/app/models/career';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-students-form',
  templateUrl: './students-form.component.html',
  styleUrls: ['./students-form.component.css']
})
export class StudentsFormComponent implements OnInit {

  title = 'Registrar Alumno';

  student: Student = new Student();
  careers: Career[];
  studiesModality: StudyMode[];

  error: any;

  constructor(private studentService: StudentsService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id: number = +params.get('id');
      if (id) {
        this.studentService.getById(id).subscribe(student => this.student = student)
      }
    })

    this.studentService.getCareers().subscribe(careers => this.careers = careers);

    this.studentService.getStudiesModality().subscribe(studiesModality => this.studiesModality = studiesModality);
  }

  public newStudent(): void {
    this.studentService.register(this.student).subscribe(student => {
      console.log(student);
      Swal.fire('Nuevo:', `Alumno ${student.firstName} , ${student.lastName} creado con éxito`, 'success');
      this.router.navigate(['/students']);
    }, err => {
      if (err.status === 400) {
        this.error = err.error;
        console.log(this.error);
      }
    });
  }

  public updateStudent(): void {
    this.studentService.update(this.student).subscribe(student => {
      console.log(student);
      Swal.fire('Modificado:', `Alumno ${student.firstName} , ${student.lastName}actualizado con éxito`, 'success');
      this.router.navigate(['/students']);
    }, err => {
      if (err.status === 400) {
        this.error = err.error;
        console.log(this.error);
      }
    });
  }

  compareCareer(o1: Career, o2: Career): boolean {
    if (o1 === undefined && o2 === undefined) {
      return true;
    }

    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id === o2.id;
  }

  compareStudyModel(o1: StudyMode, o2: StudyMode): boolean {
    if (o1 === undefined && o2 === undefined) {
      return true;
    }

    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id === o2.id;
  }

}
