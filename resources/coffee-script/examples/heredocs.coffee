html = '''
       <strong>
         "cup" of 'coffeescript'
       </strong>
       '''

html = """
       <strong>
         "cup" of 'tea'
       </strong>
       """

$("""
  <div id='#{ @getID() }' class='tree'>
    <ul class='#{ if @sortable then 'sortable' else '' }'></ul>
  </div>
  """)
