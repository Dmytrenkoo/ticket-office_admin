package ua.com.kisit.ticketoffice.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.kisit.ticketoffice.entity.Tickets;

import java.util.ArrayList;
import java.util.List;

    @Setter
    @Getter
    public class Cart {

        List<ItemCart> cart;
        private double totalValue;
        private int sumElInCart;

        public Cart() {
            this.cart = new ArrayList<>();
            this.totalValue = 0;
            this.sumElInCart = 0;
        }

        public synchronized void addNewItemToCart(Tickets tickets, int quantity){
            boolean logic = true;

            for(ItemCart el: cart){
                if(el.getTickets().getId()==tickets.getId()){
                    logic = false;
                    el.setQuantity(el.getQuantity()+quantity);
                }
            }

            if(logic) cart.add(new ItemCart(tickets, quantity));
        }

        public synchronized void updateItemInCart(Tickets tickets, int quantity){

            if(quantity<=0){
                for(ItemCart el: cart){
                    if(el.getTickets().getId()==tickets.getId()){
                        cart.remove(el);
                        break;
                    }
                }
            } else {
                for(ItemCart el: cart){
                    if(el.getTickets().getId()==tickets.getId()){
                        el.setQuantity(quantity);
                    }
                }
            }

        }


        public synchronized void deleteItemFromCart(Tickets tickets){
            for(ItemCart el: cart){
                if(el.getTickets().getId()==tickets.getId()){
                    cart.remove(el);
                    break;
                }
            }
        }


        public synchronized  void deleteAllItemFromCart(){
            cart.clear();
            totalValue = 0;
            sumElInCart = 0;
        }

        public synchronized double getTotalValue() {

            totalValue = 0;
            for (ItemCart el : cart){
                totalValue += el.getQuantity() * el.getTickets().getPrice().doubleValue();
            }

            return totalValue;
        }

        public synchronized int getSumElInCart() {
            int a = cart.size();
            sumElInCart = a;
            return a;
        }
    }
