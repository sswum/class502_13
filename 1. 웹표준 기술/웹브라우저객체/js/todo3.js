const todo = {
  id: 0,
  data: [], // 스케줄 데이터
  tpl: "", //스케줄 목록 템플릿 HTML
  parser: nul,

  init() {
    //스케줄 목록 템플릿 가져오기
    const tplEl = document.getElementById("tpl");
    this.tpl = tplEl.innerHTML;
    this.parser = new DOMParser(); //parse, parser :변환
    // 저장값조회 ->스케줄 완성}

    const jsonData = localStorage.getItem("todos");
    const todos = jsonData ? JSON.parse(jsonData) : [];
    console.log(todos);

    this.data = todos;
    this.id = todos.length;

    const itemsEl = document.querySelector(".itmes");
    for (const item of todos) {
      //Symbo.iterator / 반복자 패턴/ 반복이 필요한 객체
      const liEl = this.getItem(item.title);
      liEl.dataset.id = item.id;
      itemsEl.appendChild(liEl);
    }
  },

  /**
   * 스케줄 추가
   *
   */
  add() {
    const subject = frmRegist.subject.value;

    if (!subject.trim()) {
      // 좌우 공백 제거
      alert("할일을 입력하세요.");
      return;
    }

    const liEl = document.createElement("li");
    liEl.appendChild(document.createTextNode(subject));

    const buttonEl = document.createElement("button");
    buttonEl.appendChild(document.createTextNode("삭제"));
    liEl.appendChild(buttonEl);

    const itemsEl = document.querySelector(".items");
    itemsEl.appendChild(liEl);

    // 스케줄 삭제
    buttonEl.addEventListener("click", function () {
      itemsEl.removeChild(liEl);
    });

    frmRegist.subject.value = "";
    frmRegist.subject.focus();

    let { data } = this;
    let id = this.id++;
    data.push({
      id,
      title: subject,
    });

    this.data.push({
      id: this.id++,
      title: subject,
    });

    this.save();

    liEl.dataset.id = id;
  },
  save() {
    localStorage.setItem("todos", JSON.stringify(this.data));
  },
  getItem(subject) {
    let html = this.tpl;
    html = html.replace(/#subject/g, subject).replace(/#id/g, this.id++);

    const dom = this.parser.parseFromString(html, "text/html");
    const liEl = dom.querySelector("li");
    const buttonEl = liEl.querySelector("button");
    const itemsEl = document.querySelector(".items");
    itemsEl.removeChild(liEl);

    buttonEl.addEventListener("click", function () {
        const itemsEl = document.querySelector(".items");
        itemsEl.removeChild(liEl);
      
        //localStorage에 저장된 데이터도 삭제
        const id = liEl.dataset.id;
        const index = todo.data.findIndex((item) => item.id === id);
        if (index !== -1) {
          todo.data.splice(index, 1);
          todo.save();
        }
      });
   


  },
};

window.addEventListener("DOMContentLoaded", function () {
  todo.init(); //데이터 조회 및 완성
  frmRegist.addEventListener("submit", function (e) {
    e.preventDefault();
    todo.add(); // 스케줄 추가
  });
});
