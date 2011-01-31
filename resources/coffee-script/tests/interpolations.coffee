quote  = "A picture is a fact. -- #{ author }"

sentence = "#{ 22 / 7 } is a decent approximation of π"

html = """
       <strong>
         cup of #{ beverage }
       </strong>
       """

quizHtml += """
               <div class="quizItem">
                  <span class="quizNumber">#{index+1}</span>
                  <div class="quizSentence" id="qs#{index+1}">#{item.question}</div>
               </div>
            """
