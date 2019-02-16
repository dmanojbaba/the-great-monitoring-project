import React, { Component } from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {value: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    var my_url = "http://docker.for.mac.localhost:9100/hello?name=" + this.state.value;
    //var my_url = "http://docker.for.mac.localhost:9100/time";
    //var my_url = "https://jsonplaceholder.typicode.com/todos/1";
    console.log(my_url);
    fetch(my_url)
    .then(results => results.json())
    .then(response => {
      this.setState({content: response.content});
      this.setState({result: JSON.stringify(response)});
      }).catch(err => {
      this.setState({content: ""});
      this.setState({result: "*** Backend Error ***"});
      });
    event.preventDefault();
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <p>Hello Frontend!</p>
        </header>
        <form class="form-inline" onSubmit={this.handleSubmit}>
          <div class="row">
            <div class="form-group col-centered mx-sm-2">
              <input type="text" class="form-control" placeholder="Enter Text" value={this.state.value} onChange={this.handleChange} />
            </div>
            <button type="submit" class="btn btn-success">Submit</button>
          </div>
        </form>
        <br />
        <div>
          <p>
            {this.state.content}
          </p>
          <code>
            {this.state.result}
          </code>
        </div>
      </div>
    );
  }
}

export default App;