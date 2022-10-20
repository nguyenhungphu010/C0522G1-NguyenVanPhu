import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {Country} from "../model/country";
import {UserRegister} from "../model/userRegister";


@Component({
  selector: 'app-resister-form',
  templateUrl: './resister-form.component.html',
  styleUrls: ['./resister-form.component.css']
})
export class ResisterFormComponent implements OnInit {
  countries: Country[] = [];
  user: UserRegister = {};
  users: UserRegister[] = [];
  userForm: FormGroup;
  errMessage: string;

  constructor() {
    this.countries = [
      {id: 0, name: 'Quang Tri'},
      {id: 1, name: 'Da Nang'},
      {id: 2, name: 'Ha Noi'},
      {id: 3, name: 'HCM'},
      {id: 4, name: 'Hue'}
    ]
    this.userForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      country: new FormGroup({
        id: new FormControl('', [Validators.required])
      }),
      age: new FormControl('', [Validators.min(18), Validators.max(100), Validators.required]),
      gender: new FormControl(),
      phoneNumber: new FormControl('', Validators.pattern('^\\+84\\d{9,10}$')),
      pass: new FormGroup({
        password: new FormControl('', [Validators.minLength(6), Validators.required]),
        confirmPassword: new FormControl('', [Validators.minLength(6), Validators.required])
      }, this.checkConfirmPassword)
    })
  }

  ngOnInit(): void {
  }
  submit() {
    this.user = {
      email: this.userForm.value.email,
      password: this.userForm.value.pass.password,
      age: this.userForm.value.age,
      gender: this.userForm.value.gender,
      phoneNumber: this.userForm.value.phoneNumber,
      country: this.userForm.value.country
    }
    if (this.userForm.valid) {
      this.users.push(this.user);
      this.errMessage = '';
      this.userForm.reset();
    } else {
      this.errMessage = 'Enter plz!';
    }
  }
  checkConfirmPassword(pass: AbstractControl) {
    let value = pass.value;
    if (value.password != value.confirmPassword) {
      return {'confirmPass' : true};
    }
    return null;
  }
}
