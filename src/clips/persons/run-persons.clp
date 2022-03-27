;; Loading person's template and facts to Jess Working Memory
(load "clips/persons/load-persons.clp")
;; Loading person rules ...
(load "clips/persons/load-persons-rules.clp")
(reset)

;; Displaying Jess Working Memory contents (known facts)
***********************************************
Current stored facts in CLIPS Working Memory:
(facts)

***********************************************
;; Calling run function (Jess inference engine) to query the Working Memory via the rules in load-rules.clp
;; and find out which rules fire ... displaying data

***********************************************
********************Execute********************
***********************************************
(run)

***********************************************
********************End************************
***********************************************
;;Erase all Facts and Rules
(clear)
