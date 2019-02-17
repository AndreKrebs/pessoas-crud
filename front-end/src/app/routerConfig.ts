import { Routes } from '@angular/router';

import { PersonIndexComponent } from './components/person/index/index.component';
import { PersonFormComponent } from './components/person/form/form.component';
import { DependentFormComponent } from './components/dependent/form/form.component';

export const appRoutes: Routes = [
  { 
    path: 'dependente/:people/:id', // edit
    component: DependentFormComponent
  },
  { 
    path: 'dependente/:people', // new
    component: DependentFormComponent 
  },
  { 
    path: 'pessoa/novo', // new
    component: PersonFormComponent 
  },
  { 
    path: 'pessoa/:id', // edit
    component: PersonFormComponent
  },
  { 
    path: 'pessoa', 
    component: PersonIndexComponent
  }
];