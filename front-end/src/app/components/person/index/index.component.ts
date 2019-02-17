import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { RestService } from '../../../services/rest/rest.service'


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class PersonIndexComponent implements OnInit {

  title:string = "Pessoas Cadastradas";

  peoples:any = [];

  constructor(public rest: RestService, private router: Router) {}

  ngOnInit() {
    this.getPeoples();
  }

  getPeoples() {
    this.peoples = [];
    this.rest.getRequest('people').subscribe((data: {}) => {
      this.peoples = data;
    });
  }

  addNew() {
    this.router.navigate(['/pessoa/novo']);
  }

  addNewDependent(idPeople: number) {
    this.router.navigate(['/dependente/novo/'+idPeople]);
  }

}
