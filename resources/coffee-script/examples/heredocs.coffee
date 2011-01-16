html = '''
       <strong>
         "cup" of\t'coffeescript'
       </strong>
       '''

html = """
       <strong>
         "cup" of\t'tea'
       </strong>
       """

$("""
  <div id='#{ @getID() }' class='tree'>
    <ul class='#{ if @sortable then 'sortable' else '' }'></ul>
  </div>
  """)
