import { StudentsService } from './../../services/students.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Student } from 'src/app/models/student';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  title = 'Listado de Alumnos';
  students: Student[];

  totalRecords = 0;
  pageCurrent = 0;
  totalPage = 4;
  pageSizeOptions: number[] = [3, 5, 10, 25, 100];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private studentService: StudentsService) { }

  ngOnInit(): void {
    this.calculateRanges();
  }

  paging(event: PageEvent): void {
    this.pageCurrent = event.pageIndex;
    this.totalRecords = event.pageSize;
    this.calculateRanges();
  }

  private calculateRanges() {
    this.studentService.getAllPageable(this.pageCurrent.toString(), this.totalRecords.toString())
      .subscribe(p => {
        this.students = p.content as Student[];
        this.totalRecords = p.totalElements as number;
        this.paginator._intl.itemsPerPageLabel = 'Registros por página:';
      });
  }

  public delete(student: Student): void {

    Swal.fire({
      title: 'Cuidado:',
      text: `¿Seguro que desea eliminar a ${student.firstName},  ${student.lastName} ?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!'
    }).then((result) => {
      if (result.value) {
        this.studentService.delete(student.id).subscribe(() => {
          //this.alumnos = this.alumnos.filter(a => a !== alumno);
          this.calculateRanges();
          Swal.fire('Eliminado:', `Alumno ${student.firstName}, ${student.lastName} eliminado con éxito`, 'success');
        });
      }
    });

  }
}
