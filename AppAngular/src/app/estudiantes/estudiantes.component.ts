import { Component, OnInit } from '@angular/core';
import {EstudiantesServiceService} from './estudiantes-service.service';

@Component({
  selector: 'app-estudiantes',
  templateUrl: './estudiantes.component.html',
  styleUrls: ['./estudiantes.component.css']
})
export class EstudiantesComponent implements OnInit {

  estudiantes: any;

  constructor(private estService: EstudiantesServiceService) { }

  ngOnInit() {
    this.loadEst();
  }

  loadEst() {
    this.estService.getDepartamentos().subscribe(
      Est => this.estudiantes = Est
      );
  }

}
