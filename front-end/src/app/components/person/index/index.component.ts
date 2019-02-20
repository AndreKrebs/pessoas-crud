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
  dependentTypes:any = [];

  constructor(public rest: RestService, private router: Router) {}

  ngOnInit() {
    this.getDependentTypes();
    this.getPeoples();
  }

  getDependentTypes() {
    this.rest.getRequest('dependent/dependent-type').subscribe((data: {}) => {
      this.dependentTypes = data;
    });
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
    this.router.navigate(['/dependente/'+idPeople]);
  }

  editPeople(idPeople: number) {
    this.router.navigate(['/pessoa/'+idPeople]);
  }

  editDependent(idPeople: number, idDependent: number) {
    this.router.navigate(['/dependente/'+idPeople+'/'+idDependent]);
  }

  deletePeople(idPeople: number, name: string) {
    if(confirm("Deseja excluir o usuário " + name + " e todos os dependentes ?")) {
      this.rest.deleteRequest('people/'+idPeople).subscribe( data => {
        this.getPeoples();
      });
    }
  }

  deleteDependent(idDependent: number, name: string) {
    if(confirm("Deseja excluir o dependente " + name+ " ?")) {
      this.rest.deleteRequest('dependent/'+idDependent).subscribe( data => {
        this.getPeoples();
      });
    }
  }

}
