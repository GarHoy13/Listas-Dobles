
public class ListaDoble{
    Node topForward;
    Node topBackward;
    public boolean insertaPrimerNodo(String dato){
	if (topForward == null) { 
		topForward = new Node();
		topForward.name = dato;
		topForward.previous = null;
		topForward.next = null;
			
		topBackward = topForward;

		return true;
        }
	else {
		return false;
	}
    }
	
    public void imprimir(){
	System.out.print("[X]"); 

	for (Node temp = this.topForward; temp != null; temp = temp.next){
			System.out.print(" <- [ " + temp.name + " ] -> ");
	}

	System.out.print("[X]\n"); 
    }
	
    public String toString(){
	String cadAux = "[X]";
	for (Node temp = this.topForward; temp != null; temp = temp.next){
			cadAux += " <- [ " + temp.name + " ] -> ";
	}

	cadAux += "[X]\n"; 

	return cadAux;
    }

    public boolean insertaAntesPrimerNodo(String nombre) {
        if (topForward == null) {
            // La lista está vacía
            topForward = new Node();
            topForward.name = nombre;
            topForward.previous = null;
            topForward.next = null;

            topBackward = topForward;

            return true;
        } else {
            Node temp = new Node();
            temp.name = nombre;
            temp.next = topForward;
            topForward.previous = temp;
            topForward = temp;
            temp = null;

            return true;
        }
    }

    public void insertaAlFinal(String nombre){
	Node temp = new Node ();
	temp.name = nombre;
	temp.next = null;	
	temp.previous = this.topBackward;
	this.topBackward.next = temp;
	this.topBackward = temp;
	temp = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
	Node temp = new Node();
	temp.name = nombre;
	Node temp2 = this.topForward;

	while ( (temp2 != null) 
				&& temp2.name.equals(buscado) == false ) {	
		         temp2 = temp2.next;
	}

	if (temp2 != null){ 
		temp.next = temp2.next;
		temp2.next = temp;

		temp.previous = temp2;
		if (temp.next != null) {
                    temp.next.previous = temp;
                }

		temp = null;
		temp2 = null;
			
		return true;
	}
	else return false;
    } 

    public void borrarNodoPorValor(String valor) {
        Node temp = topForward;

        // Caso primer nodo
        if (temp != null && temp.name.equals(valor)) {
            topForward = temp.next;
            if (topForward != null) {
                topForward.previous = null;
            }
            temp.next = null;
            temp = null;
            return;
        }
        
        while (temp != null && !temp.name.equals(valor)) {
            temp = temp.next;
        }

        if (temp != null) {
            
            if (temp.previous != null) {
                temp.previous.next = temp.next;
            }

            if (temp.next != null) {
                temp.next.previous = temp.previous;
            }

            // Caso último nodo
            if (temp == topBackward) {
                topBackward = temp.previous;
            }

            temp.next = null;
            temp.previous = null;
            temp = null;
        }
    }


    public Node buscarNodoPorValor(String valor) {
        Node temp = this.topForward;
        while (temp != null && !temp.name.equals(valor)) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertarDespuesDeNodo(String valorBuscado, String nuevoValor) {
        Node nodoBuscado = buscarNodoPorValor(valorBuscado);
        if (nodoBuscado != null) {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoValor;

            nuevoNodo.next = nodoBuscado.next;
            if (nodoBuscado.next != null) {
                nodoBuscado.next.previous = nuevoNodo;
            }

            nuevoNodo.previous = nodoBuscado;
            nodoBuscado.next = nuevoNodo;
        }
    }

    public void intercambiarNodos(String valorNodo1, String valorNodo2) {
       Node nodo1 = buscarNodoPorValor(valorNodo1);
       Node nodo2 = buscarNodoPorValor(valorNodo2);

       if (nodo1 != null && nodo2 != null && nodo1 != nodo2) {
         Node tempNext1 = nodo1.next;
         nodo1.next = nodo2.next;
         nodo2.next = tempNext1;

         Node tempNext2 = nodo1.next;
         nodo1.next = nodo2.next;
         nodo2.next = tempNext2;

         Node tempPrevious1 = nodo1.previous;
         nodo1.previous = nodo2.previous;
         nodo2.previous = tempPrevious1;

         Node tempPrevious2 = nodo1.previous;
         nodo1.previous = nodo2.previous;
         nodo2.previous = tempPrevious2;

          if (nodo1.next != null) {
            nodo1.next.previous = nodo1;
          } else {
            topBackward = nodo1; 
         }

          if (nodo1.previous != null) {
            nodo1.previous.next = nodo1;
          } else {
            topForward = nodo1; 
         }

          if (nodo2.next != null) {
            nodo2.next.previous = nodo2;
          } else {
            topBackward = nodo2; 
         }

          if (nodo2.previous != null) {
            nodo2.previous.next = nodo2;
          } else {
            topForward = nodo2; 
         }
       }
    }
}
