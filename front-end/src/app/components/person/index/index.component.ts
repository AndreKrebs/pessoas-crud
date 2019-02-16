import { Component, OnInit } from '@angular/core';

import { RestService } from '../../../services/rest/rest.service'
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class PersonIndexComponent implements OnInit {

  title:string = "Pessoas Cadastradas";

  peoples:any = [];

  constructor(public rest: RestService) {}

  ngOnInit() {
    this.getPeoples();
  }

  getPeoples() {
    this.peoples = [];
    this.rest.getRequest('people/dependents').subscribe((data: {}) => {
      this.peoples = data;
    });
  }

  

}
