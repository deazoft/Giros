import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// HttpClient module for RESTful API
import { HttpClientModule } from '@angular/common/http';

import { EstudiantesComponent } from './estudiantes/estudiantes.component';
import { EstudiantesServiceService} from './estudiantes/estudiantes-service.service';

@NgModule({
  declarations: [
    AppComponent,
    EstudiantesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [EstudiantesServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
