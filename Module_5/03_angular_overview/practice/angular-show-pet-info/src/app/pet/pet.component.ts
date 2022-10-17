import {Component, OnInit} from '@angular/core';
import {Pet} from "../pet";

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {

  pet: Pet ={
    name: 'Đại Lợi',
    image: 'https://i.pinimg.com/564x/e9/1c/d2/e91cd26a89972682913156cd966ab2de.jpg'
  };

constructor()
{
}

ngOnInit()
:
void {}

}
