import { Routes } from '@angular/router';

import { PersonIndexComponent } from './components/person/index/index.component';
import { PersonFormComponent } from './components/person/form/form.component';

export const appRoutes: Routes = [
  { path: 'create', 
    component: PersonFormComponent 
  },
  { path: 'index',
    component: PersonIndexComponent
  }
];