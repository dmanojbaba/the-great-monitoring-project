import React, { useState } from "react";
import "./App.css";

function App() {
  const [textValue, setTextValue] = useState("");
  const [response, setResponse] = useState("Hello Frontend");

  const handleSubmit = async (event) => {
    event.preventDefault();

    const backend_server =
      window._env_.REACT_APP_BACKEND_SERVER ||
      process.env.REACT_APP_BACKEND_SERVER;

    var backend_url = backend_server + "/greeting?name=" + textValue;
    // var backend_url = "https://jsonplaceholder.typicode.com/todos/1";

    try {
      const responseData = await fetch(backend_url);
      const responseJson = await responseData.json();
      setResponse(responseJson.content);
    } catch (error) {
      console.error("Error sending data:", error);
      setResponse("*** Backend Error ***");
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <p>{response}</p>

        <form class="form-inline" onSubmit={handleSubmit}>
          <div class="row">
            <div class="form-group col-centered mx-sm-2">
              <input
                type="text"
                class="form-control"
                placeholder="Enter Text"
                value={textValue}
                onChange={(event) => setTextValue(event.target.value)}
              />
            </div>
            <input type="submit" class="btn btn-success" value="Submit" />
          </div>
        </form>
        <br />
      </header>
    </div>
  );
}

export default App;
