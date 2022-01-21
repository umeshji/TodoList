import { ActivatedRoute, Router } from '@angular/router';
import { TodoDataService } from './../service/data/todo-data.service';
import { Component, OnInit } from '@angular/core';
import { Todo } from '../list-todos/list-todos.component';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id: number
  username: string
  todo: Todo

  constructor(
    private todoService: TodoDataService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    
    this.id = Number(this.route.snapshot.paramMap.get("id"));
    this.username = this.route.snapshot.paramMap.get("username");
    
    console.log('username is ' + this.username + ' id is ' + this.id);

    this.todo = new Todo(this.id,'',false,new Date(),this.username);
    
    if(this.id!=-1) {
      this.todoService.retrieveTodo(this.username, this.id)
          .subscribe (
            data => this.todo = data
          )
    }
  }

  saveTodo() {
    if(this.id === -1) {
      this.todoService.createTodo(this.username, this.todo)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['todos'])
            }
          )
    } else {
      this.todoService.updateTodo(this.username, this.id, this.todo)
          .subscribe (
            data => {
              console.log(data)
              this.router.navigate(['todos'])
            }
          )
    }
  }

}
