import {CustomerType} from "./customer-type";

export interface Customer {
  id?: number;
  customerType?: CustomerType;
  customerName?: string;
  customerBirthday?: string;
  customerGender?: number;
  customerIdCard?: string;
  customerPhone?: string;
  customerEmail?: string;
  customerAddress?: string;
}
