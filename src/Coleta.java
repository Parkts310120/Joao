    import java.util.Date;

    public class Coleta {
        private Date data;
        private String horario;
        private String localizacao;

        public Coleta(Date data, String horario, String localizacao) {
            this.data = data;
            this.horario = horario;
            this.localizacao = localizacao;
        }

        public Date getData() {
            return data;
        }

        public String getHorario() {
            return horario;
        }

        public String getLocalizacao() {
            return localizacao;
        }

        @Override
        public String toString() {
            return "Data: " + data + ", Horário: " + horario + ", Localização: " + localizacao;
        }
    }
