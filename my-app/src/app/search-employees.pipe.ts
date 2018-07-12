import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchEmployees'
})
export class SearchEmployeesPipe implements PipeTransform {

  transform(pipeData, pipeModifier): any {
    return pipeData.filter(eachItem => {
      return (
        eachItem['firstname'].toLowerCase().includes(pipeModifier.toLowerCase()) ||
        eachItem['lastname'].toLowerCase().includes(pipeModifier.toLowerCase())
      );
    });
  }
}
