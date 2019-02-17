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

  title:string = "Cadastrar Pessoa Dependente";
  

  constructor(private rest: RestService, public formBuilder: FormBuilder, private router: Router, 
    private activatedRoute: ActivatedRoute) {
      this.form = new FormGroup({
        id: new FormControl(),
        name: new FormControl(),
        email: new FormControl(),
        dateBird: new FormControl(),
        dependent: new FormControl()
      });

      this.activatedRoute.params.subscribe(params => {
        console.log(params)
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

  submit() {    
    if(this.form.value.id > 0) {
      this.rest.putRequest('dependent', this.form.value).subscribe((data: {}) => {
        this.dependent = data;
        if(this.dependent.id>0) {
          this.router.navigate(['/dependente/'+this.dependent.id]);
        }
        
      });
    } else {
      this.rest.postRequest('dependent', this.form.value).subscribe((data: {}) => {
        this.dependent = data;
        if(this.dependent.id>0) {
          this.router.navigate(['/dependente/'+this.dependent.id]);
        }
        
      });
    }
  }

  getDependent(id: number) {
    this.rest.getRequest('dependent/'+id).subscribe((data: {}) => {
      /*this.dependent = data;
      this.dependent.dateBird[1] = this.formatDate(this.dependent.dateBird[1]);
      this.dependent.dateBird[2] = this.formatDate(this.dependent.dateBird[2]);
      this.fieldsForm(this.dependent.id, this.dependent.name, this.dependent.email, this.dependent.dateBird.join("-"));*/
    });
  }

  getPeople(idPeople: number) {
    this.rest.getRequest('people/'+idPeople).subscribe((data: {}) => {
      console.log(">>>>>", data);
      
      this.people = data;
      this.fieldsForm("", "", "", "", this.people);
    });
  }

  fieldsForm(id: string, name: string, email:string, dateBird: string, dependent: any) {
    this.form = this.formBuilder.group({
      id: [id],
      name: [name],
      email: [email],
      dateBird: [dateBird],
      dependent: [dependent]
    });
  }

  formatDate(value: number): string {
    if(value<10) {
      return "0"+value;
    }
    return ""+value;
  }

}
