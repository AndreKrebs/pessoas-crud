import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { appRoutes } from './routerConfig'

import { PersonIndexComponent } from './components/person/index/index.component';
import { PersonFormComponent } from './components/person/form/form.component';


@NgModule({
  declarations: [
    AppComponent,
    PersonIndexComponent,
    PersonFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
