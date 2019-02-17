import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { appRoutes } from './routerConfig'

import { PersonIndexComponent } from './components/person/index/index.component';
import { PersonFormComponent } from './components/person/form/form.component';
import { DependentFormComponent } from './components/dependent/form/form.component';


@NgModule({
  declarations: [
    AppComponent,
    PersonIndexComponent,
    PersonFormComponent,
    DependentFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
