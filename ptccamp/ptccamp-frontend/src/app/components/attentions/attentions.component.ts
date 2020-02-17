import { Component, OnInit, ViewChild } from '@angular/core';
import { Student } from 'src/app/models/student';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { StudentsService } from 'src/app/services/students.service';

@Component({
  selector: 'app-attentions',
  templateUrl: './attentions.component.html',
  styleUrls: ['./attentions.component.css']
})
export class AttentionsComponent implements OnInit {

  title = 'Registro de Atención a Alumnos';
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
}

