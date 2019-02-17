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

      this.form = new FormGroup({
        id: new FormControl(),
        name: new FormControl(),
        email: new FormControl(),
        dateBirth: new FormControl(),
        peopleName: new FormControl(),
        people: new FormControl(),
        dependentType: new FormControl()
      });

      this.fieldsForm("", "", "", "", "", new Object, 0);

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
      // this.getDependent(this.idDependent);
    } else {
      this.getPeople(this.idPeople);
    }

  }

  submit() { 
    delete this.form.value['peopleName']; // não deve ser enviado, é usado apenas para o formulário
    console.log("submit", this.form.value);
    if(this.form.value.id > 0) {
      /*this.rest.putRequest('dependent', this.form.value).subscribe((data: {}) => {
        this.dependent = data;
        if(this.dependent.id>0) {
          this.router.navigate(['/dependente/'+this.dependent.id]);
        }
        
      });*/
    } else {
      this.rest.postRequest('dependent', this.form.value).subscribe((data: {}) => {
        this.dependent = data;
        if(this.dependent.id>0) {
          console.log("uri", '/dependente/'+this.dependent.people.id+'/'+this.dependent.id);
          // this.router.navigate(['/dependente/'+this.dependent.people.id+'/'+this.dependent.id]);
        }
        
      });
    }
  }

  getPeople(idPeople: number) {
    this.rest.getRequest('people/'+idPeople).subscribe((data: {}) => {
      this.people = data;

      this.people.dateBirth[1] = this.formatDate(this.people.dateBirth[1]);
      this.people.dateBirth[2] = this.formatDate(this.people.dateBirth[2]);
      this.people.dateBirth = this.people.dateBirth.join("-");

      this.fieldsForm("", "", "", "", this.people.name, this.people, 0);
    });
  }

  fieldsForm(id: string, name: string, email:string, dateBirth: string, 
    peopleName: string, people: Object, dependentType:number) {
    
    this.form = this.formBuilder.group({
      id: [id],
      name: [name],
      email: [email],
      dateBirth: [dateBirth],
      peopleName: [peopleName],
      people: [people],
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
