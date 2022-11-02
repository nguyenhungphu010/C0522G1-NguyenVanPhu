import {ObjectType} from './object-type';

export interface ObjectData {
  id?: number;
  objectType: ObjectType;
  openDate: string;
  savingDate: string;
  period: string;
  savingAmount: number;
  interestRate: number;
  promotion: string;
}
