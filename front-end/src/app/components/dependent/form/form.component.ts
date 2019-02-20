import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { RestService } from '../../../services/rest/rest.service'


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class DependentFormComponent implements OnInit {
  form: FormGroup;

  dependent: any;
  dependents:any = [];
  idDependent: number;

  people: any;
  idPeople: number;
  dependentType: any;

  title:string = "Cadastrar Pessoa Dependente";
  

  constructor(private rest: RestService, public formBuilder: FormBuilder, private router: Router, 
    private activatedRoute: ActivatedRoute) {
      this.listDependentType();

      this.fieldsForm(null, null, null, null, null, null);

      this.activatedRoute.params.subscribe(params => {
        if(params['id'] && params['people']) {
          this.idDependent = params['id'];
          this.idPeople = params['people'];
          this.title = "Editar Pessoa Dependente";
        } else if(params['people']) {
          this.idPeople = params['people'];
          this.title = "Editar Pessoa Dependente";
        }
      });


    }

  ngOnInit() {
    if(this.idDependent && this.idPeople) {
      this.getDependent(this.idDependent);
    } else {
      this.getPeople(this.idPeople);
    }
  }

  getDependent(id: number) {
    this.rest.getRequest('dependent/'+id).subscribe((data: {}) => {
      this.dependent = data;
      this.dependent.dateBirth[1] = this.formatDate(this.dependent.dateBirth[1]);
      this.dependent.dateBirth[2] = this.formatDate(this.dependent.dateBirth[2]);
      
      this.fieldsForm(this.dependent.id, this.dependent.name, this.dependent.dateBirth.join("-"), 
        this.dependent.peopleName, this.idPeople, this.dependent.dependentType)
    });  
  }

  submit() { 
    // peopleName não deve ser enviado, é usado apenas para o formulário
    delete this.form.value['peopleName']; 
    
    if(this.idDependent && this.idPeople) {
      this.rest.putRequest('dependent', this.form.value).subscribe((data: {}) => {
        this.dependent = data;
        if(!this.dependent.id) {
          alert("Ocorreu um erro");
        }
        this.router.navigate(['pessoa']);
        
      });
    } else {
      this.rest.postRequest('dependent', this.form.value).subscribe((data: {}) => {
        this.dependent = data;
        if(!this.dependent.id) {
          alert("Ocorreu um erro");
        }
        this.router.navigate(['pessoa']);
        
      });
    }
  }

  getPeople(idPeople: number) {
    this.rest.getRequest('people/'+idPeople).subscribe((data: {}) => {
      this.people = data;
      this.fieldsForm(null, null, null, this.people.name, this.people.id, null);
    });
  }

  fieldsForm(id: number, name: string, dateBirth: string, 
    peopleName: string, peopleId: Number, dependentType:number) {
    
    this.form = this.formBuilder.group({
      id: [id],
      name: [name],
      dateBirth: [dateBirth],
      peopleName: [peopleName],
      peopleId: [peopleId],
      dependentType: [dependentType]
    });
  }

  listDependentType() {
    
    this.rest.getRequest('dependent/dependent-type').subscribe((data: {}) => {
      this.dependentType = data;
    });
  }

  formatDate(value: number): string {
    if(value<10) {
      return "0"+value;
    }
    return ""+value;
  }

}
