import {Country} from "./country";

export interface UserRegister {
  email?: string,
  password?: string,
  country?: Country,
  age?: number,
  gender?: number,
  phoneNumber?: string
}
