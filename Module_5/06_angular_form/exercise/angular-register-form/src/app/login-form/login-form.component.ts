import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  private formUserLogin: FormGroup;
  message: string;

  constructor() {
    this.formUserLogin = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.minLength(6), Validators.required])
    })
  }

  ngOnInit(): void {
  }
  login() {
    if (this.formUserLogin.valid) {
      this.message = 'Welcome back: ' + this.formUserLogin.controls.email.value;
    } else {
      this.message = 'Enter plz!';
    }
  }
}
