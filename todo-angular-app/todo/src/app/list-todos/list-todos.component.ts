import { TodoDataService } from './../service/data/todo-data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

export class Todo {
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date,
    public username: string,
  ){

  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos: Todo[]
  message: string
  username : string

  constructor(
    private todoService:TodoDataService,
    private router : Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
     this.username = sessionStorage.getItem('authenticaterUser');
    this.refreshTodos(this.username);
  }

  refreshTodos(username){
    
    this.todoService.retrieveAllTodos(username).subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    )
  }

  deleteTodo(username,id) {
    this.todoService.deleteTodo(username, id).subscribe (
      response => {
        console.log(response);
        this.message = `Delete of Todo  ${id} Successful!`;
        this.refreshTodos(username);
      }
    )
  }

  updateTodo(username,id) {
    this.router.navigate(['todos',id,username])
  }

  addTodo() {
    this.router.navigate(['todos',-1,this.username])
  }
}
